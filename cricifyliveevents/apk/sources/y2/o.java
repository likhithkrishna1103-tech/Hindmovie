package y2;

import v1.p1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f14707a = new n();

    public final void a() {
        try {
            ((o) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(p1.class).newInstance(this.f14707a)).a();
        } catch (Exception e9) {
            throw new IllegalStateException(e9);
        }
    }
}
