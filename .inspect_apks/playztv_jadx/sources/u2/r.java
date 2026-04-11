package u2;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements GLSurfaceView.Renderer {
    public static final float[] E = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
    public static final float[] F = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
    public static final float[] G = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
    public static final String[] H = {"y_tex", "u_tex", "v_tex"};
    public static final FloatBuffer I = s1.b.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    public d4.e0 B;
    public int C;
    public VideoDecoderOutputBuffer D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final s f12644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f12645v = new int[3];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int[] f12646w = new int[3];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f12647x = new int[3];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f12648y = new int[3];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicReference f12649z = new AtomicReference();
    public final FloatBuffer[] A = new FloatBuffer[3];

    public r(s sVar) {
        this.f12644u = sVar;
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.f12647x;
            this.f12648y[i] = -1;
            iArr[i] = -1;
        }
    }

    public final void a() {
        int[] iArr = this.f12645v;
        try {
            GLES20.glGenTextures(3, iArr, 0);
            for (int i = 0; i < 3; i++) {
                d4.e0 e0Var = this.B;
                GLES20.glUniform1i(GLES20.glGetUniformLocation(e0Var.f3837v, H[i]), i);
                GLES20.glActiveTexture(33984 + i);
                s1.b.b(3553, iArr[i]);
            }
            s1.b.c();
        } catch (s1.k e10) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures", e10);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.f12649z.getAndSet(null);
        if (videoDecoderOutputBuffer == null && this.D == null) {
            return;
        }
        if (videoDecoderOutputBuffer != null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.D;
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.D = videoDecoderOutputBuffer;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = this.D;
        videoDecoderOutputBuffer3.getClass();
        int i = videoDecoderOutputBuffer3.colorspace;
        GLES20.glUniformMatrix3fv(this.C, 1, false, i != 1 ? i != 3 ? F : G : E, 0);
        int[] iArr = videoDecoderOutputBuffer3.yuvStrides;
        iArr.getClass();
        ByteBuffer[] byteBufferArr = videoDecoderOutputBuffer3.yuvPlanes;
        byteBufferArr.getClass();
        int i10 = 0;
        while (i10 < 3) {
            int i11 = i10 == 0 ? videoDecoderOutputBuffer3.height : (videoDecoderOutputBuffer3.height + 1) / 2;
            GLES20.glActiveTexture(33984 + i10);
            GLES20.glBindTexture(3553, this.f12645v[i10]);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexImage2D(3553, 0, 6409, iArr[i10], i11, 0, 6409, 5121, byteBufferArr[i10]);
            i10++;
        }
        int i12 = videoDecoderOutputBuffer3.width;
        int i13 = (i12 + 1) / 2;
        int[] iArr2 = {i12, i13, i13};
        for (int i14 = 0; i14 < 3; i14++) {
            int[] iArr3 = this.f12647x;
            int i15 = iArr3[i14];
            int i16 = iArr2[i14];
            int[] iArr4 = this.f12648y;
            if (i15 != i16 || iArr4[i14] != iArr[i14]) {
                s1.d.g(iArr[i14] != 0);
                float f = iArr2[i14] / iArr[i14];
                FloatBuffer floatBufferE = s1.b.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                FloatBuffer[] floatBufferArr = this.A;
                floatBufferArr[i14] = floatBufferE;
                GLES20.glVertexAttribPointer(this.f12646w[i14], 2, 5126, false, 0, (Buffer) floatBufferArr[i14]);
                iArr3[i14] = iArr2[i14];
                iArr4[i14] = iArr[i14];
            }
        }
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        try {
            s1.b.c();
        } catch (s1.k e10) {
            Log.e("VideoDecoderGLSV", "Failed to draw a frame", e10);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i10) {
        GLES20.glViewport(0, 0, i, i10);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f12646w;
        try {
            d4.e0 e0Var = new d4.e0("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.B = e0Var;
            GLES20.glVertexAttribPointer(e0Var.g("in_pos"), 2, 5126, false, 0, (Buffer) I);
            iArr[0] = this.B.g("in_tc_y");
            iArr[1] = this.B.g("in_tc_u");
            iArr[2] = this.B.g("in_tc_v");
            this.C = GLES20.glGetUniformLocation(this.B.f3837v, "mColorConversion");
            s1.b.c();
            a();
            s1.b.c();
        } catch (s1.k e10) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e10);
        }
    }
}
