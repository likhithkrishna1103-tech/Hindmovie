package p2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface l {
    void a(Bundle bundle);

    void b(int i, e2.c cVar, long j4, int i10);

    void c(int i, int i10, long j4, int i11);

    int e(MediaCodec.BufferInfo bufferInfo);

    void f(int i);

    void flush();

    void h(int i);

    boolean i(m2.e eVar);

    void l(y2.i iVar, Handler handler);

    MediaFormat m();

    void n();

    ByteBuffer o(int i);

    void p(Surface surface);

    ByteBuffer q(int i);

    void r(int i, long j4);

    void release();

    int t();
}
