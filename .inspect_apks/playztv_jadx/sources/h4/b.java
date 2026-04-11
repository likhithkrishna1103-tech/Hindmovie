package h4;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends u5.c {
    @Override // u5.c
    public final a a() {
        return new c(((AudioAttributes.Builder) this.f12782v).build());
    }

    @Override // u5.c
    public final u5.c n(int i) {
        ((AudioAttributes.Builder) this.f12782v).setUsage(i);
        return this;
    }

    @Override // u5.c
    public final void o(int i) {
        ((AudioAttributes.Builder) this.f12782v).setUsage(i);
    }
}
