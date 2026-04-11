package v4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13365e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13367h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f13371m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13372n;

    public final void a(int i) {
        if ((this.f13364d & i) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f13364d));
    }

    public final int b() {
        return this.f13366g ? this.f13362b - this.f13363c : this.f13365e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f13361a + ", mData=null, mItemCount=" + this.f13365e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f13362b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f13363c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.f13366g + ", mRunSimpleAnimations=" + this.f13368j + ", mRunPredictiveAnimations=" + this.f13369k + '}';
    }
}
