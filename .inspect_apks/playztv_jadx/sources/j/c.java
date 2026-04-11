package j;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bumptech.glide.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ObjectAnimator f6643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6644e;

    public c(AnimationDrawable animationDrawable, boolean z2, boolean z10) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z2 ? numberOfFrames - 1 : 0;
        int i10 = z2 ? 0 : numberOfFrames - 1;
        d dVar = new d();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        dVar.f6646b = numberOfFrames2;
        int[] iArr = dVar.f6645a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            dVar.f6645a = new int[numberOfFrames2];
        }
        int[] iArr2 = dVar.f6645a;
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFrames2; i12++) {
            int duration = animationDrawable.getDuration(z2 ? (numberOfFrames2 - i12) - 1 : i12);
            iArr2[i12] = duration;
            i11 += duration;
        }
        dVar.f6647c = i11;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i10);
        objectAnimatorOfInt.setAutoCancel(true);
        objectAnimatorOfInt.setDuration(dVar.f6647c);
        objectAnimatorOfInt.setInterpolator(dVar);
        this.f6644e = z10;
        this.f6643d = objectAnimatorOfInt;
    }

    @Override // com.bumptech.glide.c
    public final boolean d() {
        return this.f6644e;
    }

    @Override // com.bumptech.glide.c
    public final void u() {
        this.f6643d.reverse();
    }

    @Override // com.bumptech.glide.c
    public final void v() {
        this.f6643d.start();
    }

    @Override // com.bumptech.glide.c
    public final void w() {
        this.f6643d.cancel();
    }
}
