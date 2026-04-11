package ka;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends com.bumptech.glide.d {
    @Override // com.bumptech.glide.d
    public final void q(v vVar, float f, float f10) {
        float f11 = f10 * f;
        vVar.d(f11, 180.0f, 90.0f);
        double d10 = f11;
        vVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d10), (float) (Math.sin(Math.toRadians(0.0f)) * d10));
    }
}
