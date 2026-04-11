package androidx.emoji2.text;

import android.os.Trace;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.r4;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1191u;

    public /* synthetic */ o(int i) {
        this.f1191u = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1191u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Method method = m0.k.f8288b;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (m.f1181k != null) {
                        m.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    Method method2 = m0.k.f8288b;
                    Trace.endSection();
                    throw th;
                }
            case 1:
                return;
            case 2:
                r4.i.incrementAndGet();
                return;
            default:
                throw null;
        }
    }

    public o(s7.q qVar) {
        this.f1191u = 3;
    }

    private final void a() {
    }
}
