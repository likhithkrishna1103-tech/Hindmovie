package l4;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    @Override // l4.a
    public final a F(int i) {
        ((AudioAttributes.Builder) this.f7697v).setUsage(i);
        return this;
    }

    @Override // l4.a
    public final void G(int i) {
        ((AudioAttributes.Builder) this.f7697v).setUsage(i);
    }

    @Override // l4.a
    public final b p() {
        return new d(((AudioAttributes.Builder) this.f7697v).build());
    }
}
