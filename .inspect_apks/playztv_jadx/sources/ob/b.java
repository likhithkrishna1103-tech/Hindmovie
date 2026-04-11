package ob;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9483u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f9484v;

    public /* synthetic */ b(c cVar, int i) {
        this.f9483u = i;
        this.f9484v = cVar;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        pb.a aVarM;
        pb.a aVarI;
        switch (this.f9483u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f9484v.b();
                return;
            case 1:
                this.f9484v.b();
                return;
            default:
                c cVar = this.f9484v;
                synchronized (c.f9485m) {
                    try {
                        ga.g gVar = cVar.f9486a;
                        gVar.a();
                        k4 k4VarL = k4.l(gVar.f5346a);
                        try {
                            aVarM = cVar.f9488c.m();
                            if (k4VarL != null) {
                                k4VarL.A();
                            }
                        } catch (Throwable th) {
                            if (k4VarL != null) {
                                k4VarL.A();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i = aVarM.f10301b;
                    if (i == 5) {
                        aVarI = cVar.i(aVarM);
                    } else {
                        if (i == 3) {
                            aVarI = cVar.i(aVarM);
                        } else if (!cVar.f9489d.a(aVarM)) {
                            return;
                        } else {
                            aVarI = cVar.c(aVarM);
                        }
                    }
                    cVar.f(aVarI);
                    cVar.m(aVarM, aVarI);
                    if (aVarI.f10301b == 4) {
                        cVar.l(aVarI.f10300a);
                    }
                    int i10 = aVarI.f10301b;
                    if (i10 == 5) {
                        cVar.j(new e());
                        return;
                    } else if (i10 == 2 || i10 == 1) {
                        cVar.j(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        cVar.k(aVarI);
                        return;
                    }
                } catch (e e10) {
                    cVar.j(e10);
                    return;
                }
        }
    }
}
