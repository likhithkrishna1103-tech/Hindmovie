package q4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10939e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10941h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10942j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10943k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10944l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10945m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10946n;

    public final void a(int i) {
        if ((this.f10938d & i) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f10938d));
    }

    public final int b() {
        return this.f10940g ? this.f10936b - this.f10937c : this.f10939e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f10935a + ", mData=null, mItemCount=" + this.f10939e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f10936b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f10937c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.f10940g + ", mRunSimpleAnimations=" + this.f10942j + ", mRunPredictiveAnimations=" + this.f10943k + '}';
    }
}
