package dd;

import androidx.media3.decoder.DecoderInputBuffer;
import b7.s;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4176u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ s f4177v;

    public /* synthetic */ m(s sVar, zc.e eVar, int i) {
        this.f4176u = i;
        this.f4177v = sVar;
    }

    private final void a() {
        s sVar = this.f4177v;
        synchronized (sVar.f1900c) {
            try {
                Iterator it = ((ArrayList) sVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        s sVar = this.f4177v;
        synchronized (sVar.f1900c) {
            try {
                Iterator it = ((ArrayList) sVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        s sVar = this.f4177v;
        synchronized (sVar.f1900c) {
            try {
                Iterator it = ((ArrayList) sVar.f).iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4176u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return;
            case 1:
                b();
                return;
            case 2:
                c();
                return;
            default:
                s sVar = this.f4177v;
                synchronized (sVar.f1900c) {
                    try {
                        Iterator it = ((ArrayList) sVar.f).iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
