package y2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements GLSurfaceView.Renderer {
    public static final float[] F = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    public static final float[] G = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
    public static final float[] H = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
    public static final String[] I = {"y_tex", "u_tex", "v_tex"};
    public static final FloatBuffer J = y1.b.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    public ff.m C;
    public int D;
    public VideoDecoderOutputBuffer E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s f14721v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f14722w = new int[3];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f14723x = new int[3];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f14724y = new int[3];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f14725z = new int[3];
    public final AtomicReference A = new AtomicReference();
    public final FloatBuffer[] B = new FloatBuffer[3];

    public r(s sVar) {
        this.f14721v = sVar;
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.f14724y;
            this.f14725z[i] = -1;
            iArr[i] = -1;
        }
    }

    public final void a() {
        int[] iArr = this.f14722w;
        try {
            GLES20.glGenTextures(3, iArr, 0);
            for (int i = 0; i < 3; i++) {
                ff.m mVar = this.C;
                GLES20.glUniform1i(GLES20.glGetUniformLocation(mVar.f4599w, I[i]), i);
                GLES20.glActiveTexture(33984 + i);
                y1.b.b(3553, iArr[i]);
            }
            y1.b.c();
        } catch (y1.k e9) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures", e9);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.A.getAndSet(null);
        if (videoDecoderOutputBuffer == null && this.E == null) {
            return;
        }
        if (videoDecoderOutputBuffer != null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.E;
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.E = videoDecoderOutputBuffer;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = this.E;
        videoDecoderOutputBuffer3.getClass();
        int i = videoDecoderOutputBuffer3.colorspace;
        GLES20.glUniformMatrix3fv(this.D, 1, false, i != 1 ? i != 3 ? G : H : F, 0);
        int[] iArr = videoDecoderOutputBuffer3.yuvStrides;
        iArr.getClass();
        ByteBuffer[] byteBufferArr = videoDecoderOutputBuffer3.yuvPlanes;
        byteBufferArr.getClass();
        int i10 = 0;
        while (i10 < 3) {
            int i11 = i10 == 0 ? videoDecoderOutputBuffer3.height : (videoDecoderOutputBuffer3.height + 1) / 2;
            GLES20.glActiveTexture(33984 + i10);
            GLES20.glBindTexture(3553, this.f14722w[i10]);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexImage2D(3553, 0, 6409, iArr[i10], i11, 0, 6409, 5121, byteBufferArr[i10]);
            i10++;
        }
        int i12 = videoDecoderOutputBuffer3.width;
        int i13 = (i12 + 1) / 2;
        int[] iArr2 = {i12, i13, i13};
        for (int i14 = 0; i14 < 3; i14++) {
            int[] iArr3 = this.f14724y;
            int i15 = iArr3[i14];
            int i16 = iArr2[i14];
            int[] iArr4 = this.f14725z;
            if (i15 != i16 || iArr4[i14] != iArr[i14]) {
                y1.d.g(iArr[i14] != 0);
                float f = iArr2[i14] / iArr[i14];
                FloatBuffer floatBufferE = y1.b.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                FloatBuffer[] floatBufferArr = this.B;
                floatBufferArr[i14] = floatBufferE;
                GLES20.glVertexAttribPointer(this.f14723x[i14], 2, 5126, false, 0, (Buffer) floatBufferArr[i14]);
                iArr3[i14] = iArr2[i14];
                iArr4[i14] = iArr[i14];
            }
        }
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        try {
            y1.b.c();
        } catch (y1.k e9) {
            Log.e("VideoDecoderGLSV", "Failed to draw a frame", e9);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i10) {
        GLES20.glViewport(0, 0, i, i10);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f14723x;
        try {
            ff.m mVar = new ff.m("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.C = mVar;
            GLES20.glVertexAttribPointer(mVar.t("in_pos"), 2, 5126, false, 0, (Buffer) J);
            iArr[0] = this.C.t("in_tc_y");
            iArr[1] = this.C.t("in_tc_u");
            iArr[2] = this.C.t("in_tc_v");
            this.D = GLES20.glGetUniformLocation(this.C.f4599w, "mColorConversion");
            y1.b.c();
            a();
            y1.b.c();
        } catch (y1.k e9) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e9);
        }
    }
}
