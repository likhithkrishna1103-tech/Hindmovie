package ic;

import androidx.media3.decoder.DecoderInputBuffer;
import i2.k;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ c f6418w;

    public /* synthetic */ b(c cVar, int i) {
        this.f6417v = i;
        this.f6418w = cVar;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        jc.b bVarU;
        jc.b bVarI;
        switch (this.f6417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f6418w.b();
                return;
            case 1:
                this.f6418w.b();
                return;
            default:
                c cVar = this.f6418w;
                synchronized (c.f6419m) {
                    try {
                        ab.g gVar = cVar.f6420a;
                        gVar.a();
                        k kVarA = k.a(gVar.f390a);
                        try {
                            bVarU = cVar.f6422c.u();
                            if (kVarA != null) {
                                kVarA.v();
                            }
                        } catch (Throwable th) {
                            if (kVarA != null) {
                                kVarA.v();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i = bVarU.f6737b;
                    if (i == 5) {
                        bVarI = cVar.i(bVarU);
                    } else {
                        if (i == 3) {
                            bVarI = cVar.i(bVarU);
                        } else if (!cVar.f6423d.a(bVarU)) {
                            return;
                        } else {
                            bVarI = cVar.c(bVarU);
                        }
                    }
                    cVar.f(bVarI);
                    cVar.m(bVarU, bVarI);
                    if (bVarI.f6737b == 4) {
                        cVar.l(bVarI.f6736a);
                    }
                    int i10 = bVarI.f6737b;
                    if (i10 == 5) {
                        cVar.j(new e());
                        return;
                    } else if (i10 == 2 || i10 == 1) {
                        cVar.j(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        cVar.k(bVarI);
                        return;
                    }
                } catch (e e9) {
                    cVar.j(e9);
                    return;
                }
        }
    }
}
