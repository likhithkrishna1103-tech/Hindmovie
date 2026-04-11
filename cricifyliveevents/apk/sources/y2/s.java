package y2;

import android.content.Context;
import android.opengl.GLSurfaceView;
import androidx.media3.decoder.VideoDecoderOutputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends GLSurfaceView implements t {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f14726w = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r f14727v;

    public s(Context context) {
        super(context, null);
        r rVar = new r(this);
        this.f14727v = rVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(rVar);
        setRenderMode(0);
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        r rVar = this.f14727v;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) rVar.A.getAndSet(videoDecoderOutputBuffer);
        if (videoDecoderOutputBuffer2 != null) {
            videoDecoderOutputBuffer2.release();
        }
        rVar.f14721v.requestRender();
    }

    @Deprecated
    public t getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
