package j;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectAnimator f6478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6479b;

    public c(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z10 ? numberOfFrames - 1 : 0;
        int i10 = z10 ? 0 : numberOfFrames - 1;
        d dVar = new d();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        dVar.f6481b = numberOfFrames2;
        int[] iArr = dVar.f6480a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            dVar.f6480a = new int[numberOfFrames2];
        }
        int[] iArr2 = dVar.f6480a;
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFrames2; i12++) {
            int duration = animationDrawable.getDuration(z10 ? (numberOfFrames2 - i12) - 1 : i12);
            iArr2[i12] = duration;
            i11 += duration;
        }
        dVar.f6482c = i11;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i10);
        objectAnimatorOfInt.setAutoCancel(true);
        objectAnimatorOfInt.setDuration(dVar.f6482c);
        objectAnimatorOfInt.setInterpolator(dVar);
        this.f6479b = z11;
        this.f6478a = objectAnimatorOfInt;
    }

    @Override // n5.a
    public final void I() {
        this.f6478a.reverse();
    }

    @Override // n5.a
    public final void L() {
        this.f6478a.start();
    }

    @Override // n5.a
    public final void M() {
        this.f6478a.cancel();
    }

    @Override // n5.a
    public final boolean b() {
        return this.f6479b;
    }
}
