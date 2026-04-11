package ag;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface u extends Closeable, Flushable {
    void a0(long j4, e eVar);

    void close();

    y d();

    @Override // java.io.Flushable
    void flush();
}
