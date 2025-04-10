// Sem o uso do princípio

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

// Com o uso do princípio

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
