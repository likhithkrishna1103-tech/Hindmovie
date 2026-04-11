package j6;

import android.graphics.Color;
import android.graphics.Matrix;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o6.a f6638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o6.a f6639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f6640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f6641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f6642e;
    public final i f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f6643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Matrix f6644h;

    public h(o6.a aVar, o6.a aVar2, dd.c cVar) {
        this.f6639b = aVar;
        this.f6638a = aVar2;
        e eVarD0 = ((m6.a) cVar.f3672w).D0();
        this.f6640c = (f) eVarD0;
        eVarD0.a(this);
        aVar2.d(eVarD0);
        i iVarD0 = ((m6.b) cVar.f3673x).D0();
        this.f6641d = iVarD0;
        iVarD0.a(this);
        aVar2.d(iVarD0);
        i iVarD02 = ((m6.b) cVar.f3674y).D0();
        this.f6642e = iVarD02;
        iVarD02.a(this);
        aVar2.d(iVarD02);
        i iVarD03 = ((m6.b) cVar.f3675z).D0();
        this.f = iVarD03;
        iVarD03.a(this);
        aVar2.d(iVarD03);
        i iVarD04 = ((m6.b) cVar.A).D0();
        this.f6643g = iVarD04;
        iVarD04.a(this);
        aVar2.d(iVarD04);
    }

    public final s6.a a(Matrix matrix, int i) {
        float fL = this.f6642e.l() * 0.017453292f;
        float fFloatValue = ((Float) this.f.e()).floatValue();
        double d10 = fL;
        float fSin = ((float) Math.sin(d10)) * fFloatValue;
        float fCos = ((float) Math.cos(d10 + 3.141592653589793d)) * fFloatValue;
        float fFloatValue2 = ((Float) this.f6643g.e()).floatValue();
        int iIntValue = ((Integer) this.f6640c.e()).intValue();
        int iArgb = Color.argb(Math.round((((Float) this.f6641d.e()).floatValue() * i) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        s6.a aVar = new s6.a();
        aVar.f11541a = fFloatValue2 * 0.33f;
        aVar.f11542b = fSin;
        aVar.f11543c = fCos;
        aVar.f11544d = iArgb;
        aVar.f11545e = null;
        aVar.c(matrix);
        if (this.f6644h == null) {
            this.f6644h = new Matrix();
        }
        this.f6638a.f9528w.e().invert(this.f6644h);
        aVar.c(this.f6644h);
        return aVar;
    }

    @Override // j6.a
    public final void b() {
        this.f6639b.b();
    }

    public final void c(w wVar) {
        this.f6641d.j(new g(wVar));
    }
}
