package vc;

import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f13684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f13685b;

    public r0(e1 e1Var, f1 f1Var) {
        ge.i.e(e1Var, "timeProvider");
        ge.i.e(f1Var, "uuidGenerator");
        this.f13684a = e1Var;
        this.f13685b = f1Var;
    }

    public final k0 a(k0 k0Var) {
        String str;
        this.f13685b.getClass();
        UUID uuidRandomUUID = UUID.randomUUID();
        ge.i.d(uuidRandomUUID, "randomUUID(...)");
        String string = uuidRandomUUID.toString();
        ge.i.d(string, "toString(...)");
        String lowerCase = ne.o.X(string, "-", "").toLowerCase(Locale.ROOT);
        ge.i.d(lowerCase, "toLowerCase(...)");
        return new k0(lowerCase, (k0Var == null || (str = k0Var.f13657b) == null) ? lowerCase : str, k0Var != null ? k0Var.f13658c + 1 : 0, this.f13684a.a().f13603b);
    }
}
