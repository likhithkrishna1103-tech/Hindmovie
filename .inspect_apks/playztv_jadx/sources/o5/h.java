package o5;

import android.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f9385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f9386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f9387e;
    public final i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9388g = true;

    public h(a aVar, t5.b bVar, zc.c cVar) {
        this.f9383a = aVar;
        e eVarD0 = ((r5.a) cVar.f14945u).D0();
        this.f9384b = (f) eVarD0;
        eVarD0.a(this);
        bVar.d(eVarD0);
        e eVarD02 = ((r5.b) cVar.f14946v).D0();
        this.f9385c = (i) eVarD02;
        eVarD02.a(this);
        bVar.d(eVarD02);
        e eVarD03 = ((r5.b) cVar.f14947w).D0();
        this.f9386d = (i) eVarD03;
        eVarD03.a(this);
        bVar.d(eVarD03);
        e eVarD04 = ((r5.b) cVar.f14948x).D0();
        this.f9387e = (i) eVarD04;
        eVarD04.a(this);
        bVar.d(eVarD04);
        e eVarD05 = ((r5.b) cVar.f14949y).D0();
        this.f = (i) eVarD05;
        eVarD05.a(this);
        bVar.d(eVarD05);
    }

    public final void a(m5.a aVar) {
        if (this.f9388g) {
            this.f9388g = false;
            double dFloatValue = ((double) ((Float) this.f9386d.e()).floatValue()) * 0.017453292519943295d;
            float fFloatValue = ((Float) this.f9387e.e()).floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = ((Integer) this.f9384b.e()).intValue();
            aVar.setShadowLayer(((Float) this.f.e()).floatValue(), fSin, fCos, Color.argb(Math.round(((Float) this.f9385c.e()).floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, o5.a] */
    @Override // o5.a
    public final void b() {
        this.f9388g = true;
        this.f9383a.b();
    }

    public final void c(p2.c cVar) {
        this.f9385c.j(new g(cVar));
    }
}
