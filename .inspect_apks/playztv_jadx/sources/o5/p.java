package o5;

import android.graphics.PointF;
import l5.h0;
import q9.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends p2.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ t f9405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ p2.c f9406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ q5.b f9407z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(t tVar, p2.c cVar, q5.b bVar) {
        super(24);
        this.f9405x = tVar;
        this.f9406y = cVar;
        this.f9407z = bVar;
    }

    @Override // p2.c
    public final Object m(t tVar) {
        float f = tVar.f11151a;
        float f4 = tVar.f11152b;
        String str = ((q5.b) tVar.f).f10990a;
        String str2 = ((q5.b) tVar.f11156g).f10990a;
        float f10 = tVar.f11153c;
        float f11 = tVar.f11154d;
        float f12 = tVar.f11155e;
        t tVar2 = this.f9405x;
        tVar2.f11151a = f;
        tVar2.f11152b = f4;
        tVar2.f = str;
        tVar2.f11156g = str2;
        tVar2.f11153c = f10;
        tVar2.f11154d = f11;
        tVar2.f11155e = f12;
        String str3 = (String) ((h0) this.f9406y.f10131w);
        q5.b bVar = (q5.b) (tVar.f11154d == 1.0f ? tVar.f11156g : tVar.f);
        String str4 = bVar.f10991b;
        float f13 = bVar.f10992c;
        int i = bVar.f10993d;
        int i10 = bVar.f10994e;
        float f14 = bVar.f;
        float f15 = bVar.f10995g;
        int i11 = bVar.f10996h;
        int i12 = bVar.i;
        float f16 = bVar.f10997j;
        boolean z2 = bVar.f10998k;
        PointF pointF = bVar.f10999l;
        PointF pointF2 = bVar.f11000m;
        q5.b bVar2 = this.f9407z;
        bVar2.f10990a = str3;
        bVar2.f10991b = str4;
        bVar2.f10992c = f13;
        bVar2.f10993d = i;
        bVar2.f10994e = i10;
        bVar2.f = f14;
        bVar2.f10995g = f15;
        bVar2.f10996h = i11;
        bVar2.i = i12;
        bVar2.f10997j = f16;
        bVar2.f10998k = z2;
        bVar2.f10999l = pointF;
        bVar2.f11000m = pointF2;
        return bVar2;
    }
}
