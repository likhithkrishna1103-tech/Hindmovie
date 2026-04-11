package ka;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends com.bumptech.glide.d {
    @Override // com.bumptech.glide.d
    public final void q(v vVar, float f, float f10) {
        float f11 = f10 * f;
        vVar.d(f11, 180.0f, 90.0f);
        float f12 = f11 * 2.0f;
        r rVar = new r(0.0f, 0.0f, f12, f12);
        rVar.f = 180.0f;
        rVar.f7372g = 90.0f;
        ((ArrayList) vVar.f).add(rVar);
        p pVar = new p(rVar);
        vVar.a(180.0f);
        ((ArrayList) vVar.f7383g).add(pVar);
        vVar.f7381d = 270.0f;
        float f13 = (0.0f + f12) * 0.5f;
        float f14 = (f12 - 0.0f) / 2.0f;
        double d10 = 270.0f;
        vVar.f7379b = (((float) Math.cos(Math.toRadians(d10))) * f14) + f13;
        vVar.f7380c = (f14 * ((float) Math.sin(Math.toRadians(d10)))) + f13;
    }
}
