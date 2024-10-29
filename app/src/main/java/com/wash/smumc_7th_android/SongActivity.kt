package com.wash.smumc_7th_android


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wash.smumc_7th_android.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding : ActivitySongBinding
    lateinit var song : Song
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSong()

        setPlayer(song)

        binding.songDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }

        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }
        binding.songRepeatIv.setOnClickListener {
            toggleRepeatMode(true)
        }
        binding.songAllIv.setOnClickListener {
            toggleRepeatMode(false)
        }
    }
    override fun onDestroy(){
        super.onDestroy()
        timer.interrupt()
    }
    private fun initSong(){
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            song = Song(
                intent.getStringExtra("title")!!,
                intent.getStringExtra("singer")!!,
                intent.getIntExtra("second", 0),
                intent.getIntExtra("playTime",0),
                intent.getBooleanExtra("isPlaying",false)
            )
        }
        startTimer()
    }

    private fun setPlayer(song : Song){
        binding.songMusicTitleTv.text = intent.getStringExtra("title")!!
        binding.songSingerNameTv.text = intent.getStringExtra("singer")!!
        binding.songStartTimeTv.text = String.format("%02d:%02d", song.second / 60, song.second %60)
        binding.songEndTimeTv.text = String.format("%02d:%02d", song.playTime / 60, song.playTime %60)
        binding.songProgressSb.progress = (song.second *1000 / song.playTime)

        setPlayerStatus(song.isPlaying)
    }

    private fun setPlayerStatus (isPlaying : Boolean){
        song.isPlaying = isPlaying
        timer.isPLaying = isPlaying
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        } else {
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

    private fun startTimer(){
        timer = Timer(song.playTime, song.isPlaying)
        timer.start()
    }

    inner class Timer(private val playTime : Int, var isPLaying : Boolean = true):Thread(){
        private var second : Int = 0
        private var mills : Float = 0f
        override fun run(){
            super.run()
            try{
                while(true){
                    if(second >= playTime){
                        break
                    }
                    if (isPLaying){
                        sleep(50)
                        mills += 50

                        runOnUiThread {
                            binding.songProgressSb.progress = ((mills/playTime)*100).toInt()
                        }
                        if ( mills % 1000 == 0f){
                            runOnUiThread {
                                binding.songStartTimeTv.text = String.format("%02d:%02d", second / 60, second %60)
                            }
                            second ++
                        }
                    }
                }

            }catch(e: InterruptedException){
                Log.d( "Song", "쓰레드가 죽었습니다. ${e.message}" )
            }

        }
    }

    fun toggleRepeatMode(isRepeatMode : Boolean) {
        if (isRepeatMode) {

            binding.songRepeatIv.visibility = View.GONE
            binding.songAllIv.visibility = View.VISIBLE

        } else {
            binding.songRepeatIv.visibility = View.VISIBLE
            binding.songAllIv.visibility = View.GONE
        }
    }
}