package a5;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import r4.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements ae.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f547v;

    public /* synthetic */ e(int i, Object obj) {
        this.f546u = i;
        this.f547v = obj;
    }

    @Override // ae.a
    public final Object b() {
        switch (this.f546u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f547v;
                Context context = jVar.f564u;
                String str = jVar.f565v;
                u5.d dVar = new u5.d(1, false);
                dVar.f12784v = null;
                i iVar = new i(context, str, dVar, jVar.f566w);
                iVar.setWriteAheadLoggingEnabled(jVar.f568y);
                return iVar;
            case 1:
                bd.c cVar = (bd.c) this.f547v;
                zc.e eVar = cVar.f2016u;
                be.h.b(cVar.C);
                zc.e eVar2 = new zc.e();
                z7.a.F(eVar, eVar2);
                return eVar2;
            case 2:
                bd.d dVar2 = (bd.d) this.f547v;
                zc.e eVar3 = dVar2.f2022u;
                be.h.b(dVar2.B);
                zc.e eVar4 = new zc.e();
                z7.a.F(eVar3, eVar4);
                return eVar4;
            case 3:
                dd.a aVar = (dd.a) ((dd.h) this.f547v).f4153c;
                zc.g gVar = aVar.f4129u;
                synchronized (gVar.f14963v) {
                    gVar.f14962u.K();
                }
                aVar.f4131w.F();
                return nd.k.f8990a;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ed.d dVar3 = (ed.d) this.f547v;
                if (!dVar3.E && !dVar3.D && a.a.A(dVar3.f4684x.f2412a) && dVar3.F > 500) {
                    dVar3.v();
                }
                return nd.k.f8990a;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return ((w) this.f547v).b();
            default:
                return ((p2.c) this.f547v).a(":memory:");
        }
    }
}
