package j2;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface m {
    int A();

    void a(int i, y1.c cVar, long j5, int i10);

    void b(Bundle bundle);

    void f(int i, int i10, long j5, int i11);

    void flush();

    int g(MediaCodec.BufferInfo bufferInfo);

    boolean h(u5.c cVar);

    void i(int i);

    void m(int i);

    void n(u2.i iVar, Handler handler);

    MediaFormat q();

    void release();

    void s();

    ByteBuffer t(int i);

    void u(Surface surface);

    ByteBuffer v(int i);

    void z(int i, long j5);
}
