package c;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.z3;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import vc.f1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d0 implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1944w;

    public /* synthetic */ d0(int i, Object obj) {
        this.f1943v = i;
        this.f1944w = obj;
    }

    @Override // fe.a
    public final Object b() {
        switch (this.f1943v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new e0((f0) this.f1944w);
            case 1:
                e5.h hVar = (e5.h) this.f1944w;
                Context context = hVar.f3801v;
                String str = hVar.f3802w;
                p6.d dVar = new p6.d(10, false);
                dVar.f10037w = null;
                e5.g gVar = new e5.g(context, str, dVar, hVar.f3803x);
                gVar.setWriteAheadLoggingEnabled(hVar.f3805z);
                return gVar;
            case 2:
                fd.c cVar = (fd.c) this.f1944w;
                dd.e eVar = cVar.f4565v;
                ge.i.b(cVar.D);
                dd.e eVar2 = new dd.e();
                z3.x(eVar, eVar2);
                return eVar2;
            case 3:
                fd.d dVar2 = (fd.d) this.f1944w;
                dd.e eVar3 = dVar2.f4570v;
                ge.i.b(dVar2.C);
                dd.e eVar4 = new dd.e();
                z3.x(eVar3, eVar4);
                return eVar4;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                hd.a aVar = (hd.a) ((hd.e) this.f1944w).f5927c;
                dd.g gVar2 = aVar.f5912v;
                synchronized (gVar2.f3687w) {
                    gVar2.f3686v.J();
                }
                aVar.f5914x.z();
                return rd.l.f11003a;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                id.d dVar3 = (id.d) this.f1944w;
                if (!dVar3.F && !dVar3.E && ab.b.r(dVar3.f6447y.f6143a) && dVar3.G > 500) {
                    dVar3.q();
                }
                return rd.l.f11003a;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                try {
                    return (List) ((fe.a) this.f1944w).b();
                } catch (SSLPeerUnverifiedException unused) {
                    return sd.p.f11669v;
                }
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return (List) this.f1944w;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                rf.q qVar = (rf.q) this.f1944w;
                qVar.getClass();
                try {
                    qVar.R.A(2, 0, false);
                    break;
                } catch (IOException e9) {
                    rf.b bVar = rf.b.f11050y;
                    qVar.a(bVar, bVar, e9);
                }
                return rd.l.f11003a;
            case 9:
                ((f1) this.f1944w).getClass();
                UUID uuidRandomUUID = UUID.randomUUID();
                ge.i.d(uuidRandomUUID, "randomUUID(...)");
                String string = uuidRandomUUID.toString();
                ge.i.d(string, "toString(...)");
                return string;
            case 10:
                return ((w4.z) this.f1944w).b();
            case 11:
                return ((vb.b) this.f1944w).a(":memory:");
            default:
                y4.p pVar = (y4.p) this.f1944w;
                return pVar.f14872v.a(pVar.f14873w);
        }
    }
}
