package jc;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.k;
import com.bumptech.glide.m;
import t6.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends m {
    @Override // com.bumptech.glide.m
    public final k f(Class cls) {
        return new b(this.f2824u, this, cls, this.f2825v);
    }

    @Override // com.bumptech.glide.m
    public final k i() {
        return (b) super.i();
    }

    @Override // com.bumptech.glide.m
    public final k n() {
        return (b) f(Drawable.class);
    }

    @Override // com.bumptech.glide.m
    public final k o() {
        return (b) super.o();
    }

    @Override // com.bumptech.glide.m
    public final k r(String str) {
        return (b) super.r(str);
    }

    @Override // com.bumptech.glide.m
    public final void u(g gVar) {
        if (gVar instanceof a) {
            super.u(gVar);
        } else {
            super.u(new a().z(gVar));
        }
    }
}
