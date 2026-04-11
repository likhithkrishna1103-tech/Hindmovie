package androidx.emoji2.text;

import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.n4;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ q f878w = new q(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f879v;

    public /* synthetic */ q(int i) {
        this.f879v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f879v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Method method = p0.k.f9880b;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (m.f863k != null) {
                        m.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    Method method2 = p0.k.f9880b;
                    Trace.endSection();
                    throw th;
                }
            case 1:
                n4.i.incrementAndGet();
                return;
            case 2:
                throw null;
            default:
                return;
        }
    }

    public q(n8.q qVar) {
        this.f879v = 2;
    }

    private final void a() {
    }
}
