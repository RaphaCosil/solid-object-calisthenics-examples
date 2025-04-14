// Sem o uso do princípio Interface Segregation Principle (ISP)

// A interface MediaPlayer tem métodos para tocar áudio e vídeo
// A classe AudioPlayer implementa a interface MediaPlayer, mas não pode tocar vídeos, o que resulta em uma exceção UnsupportedOperationException

interface MediaPlayer {
    fun playAudio()
    fun playVideo()
}

class AudioPlayer : MediaPlayer {
    override fun playAudio() {
        println("Playing audio...")
    }

    override fun playVideo() {
        throw UnsupportedOperationException("AudioPlayer cannot play videos")
    }
}

class VideoPlayer : MediaPlayer {
    override fun playAudio() {
        println("Playing audio in video player...")
    }

    override fun playVideo() {
        println("Playing video...")
    }
}

fun main1() {
    val audioPlayer = AudioPlayer()
    val videoPlayer = VideoPlayer()

    audioPlayer.playAudio()
    try { audioPlayer.playVideo() } catch (e: Exception) { println(e.message) }

    videoPlayer.playAudio()
    videoPlayer.playVideo()
}


// Com o uso do princípio Interface Segregation Principle (ISP)

// A interface MediaPlayer foi dividida em duas interfaces: AudioPlayable e VideoPlayable
// Isso permite que a classe AudioPlayer implemente apenas a interface AudioPlayable, sem precisar implementar métodos desnecessários

interface AudioPlayable {
    fun playAudio()
}

interface VideoPlayable {
    fun playVideo()
}

class AudioPlayer : AudioPlayable {
    override fun playAudio() {
        println("Playing audio...")
    }
}

class VideoPlayer : AudioPlayable, VideoPlayable {
    override fun playAudio() {
        println("Playing audio without image...")
    }

    override fun playVideo() {
        println("Playing video...")
    }
}

fun main2() {
    val audioPlayer = AudioPlayer()
    val videoPlayer = VideoPlayer()

    audioPlayer.playAudio()

    videoPlayer.playAudio()
    videoPlayer.playVideo()
}

fun main() {
    println("Sem ISP:")
    main1()

    println("\nCom ISP:")
    main2()
}
