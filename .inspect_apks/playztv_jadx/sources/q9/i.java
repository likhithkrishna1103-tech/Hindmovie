package q9;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends ga.b {
    @Override // ga.b
    public final void o(t tVar, float f, float f4) {
        tVar.d(f4 * f, 180.0f, 90.0f);
        float f10 = f4 * 2.0f * f;
        p pVar = new p(0.0f, 0.0f, f10, f10);
        pVar.f = 180.0f;
        pVar.f11145g = 90.0f;
        ((ArrayList) tVar.f).add(pVar);
        n nVar = new n(pVar);
        tVar.a(180.0f);
        ((ArrayList) tVar.f11156g).add(nVar);
        tVar.f11154d = 270.0f;
        float f11 = (0.0f + f10) * 0.5f;
        float f12 = (f10 - 0.0f) / 2.0f;
        double d10 = 270.0f;
        tVar.f11152b = (((float) Math.cos(Math.toRadians(d10))) * f12) + f11;
        tVar.f11153c = (f12 * ((float) Math.sin(Math.toRadians(d10)))) + f11;
    }
}
