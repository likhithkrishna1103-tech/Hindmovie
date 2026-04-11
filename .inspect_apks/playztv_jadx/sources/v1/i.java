package v1;

import com.playz.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z9.l f13139d = z7.a.t(new a2.t(3));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea.z f13140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pb.c f13141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13142c;

    public i(PlayerActivity playerActivity) {
        ea.z zVar = (ea.z) f13139d.get();
        s1.d.h(zVar);
        pb.c cVar = new pb.c(playerActivity, 15);
        this.f13140a = zVar;
        this.f13141b = cVar;
        this.f13142c = -1;
    }
}
