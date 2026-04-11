package u2;

import android.content.Context;
import android.opengl.GLSurfaceView;
import androidx.media3.decoder.VideoDecoderOutputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends GLSurfaceView implements t {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f12650v = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final r f12651u;

    public s(Context context) {
        super(context, null);
        r rVar = new r(this);
        this.f12651u = rVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(rVar);
        setRenderMode(0);
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        r rVar = this.f12651u;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) rVar.f12649z.getAndSet(videoDecoderOutputBuffer);
        if (videoDecoderOutputBuffer2 != null) {
            videoDecoderOutputBuffer2.release();
        }
        rVar.f12644u.requestRender();
    }

    @Deprecated
    public t getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
