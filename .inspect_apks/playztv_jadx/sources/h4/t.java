package h4;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSession f5847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f5848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f5849c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f5851e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f5852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f5853h;
    public o i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5854j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5855k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f5856l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b0 f5857m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5850d = new Object();
    public final RemoteCallbackList f = new RemoteCallbackList();

    public t(Context context, String str, Bundle bundle) {
        MediaSession mediaSessionA = a(context, str, bundle);
        this.f5847a = mediaSessionA;
        s sVar = new s(this);
        this.f5848b = sVar;
        this.f5849c = new y(mediaSessionA.getSessionToken(), sVar);
        this.f5851e = bundle;
        mediaSessionA.setFlags(3);
    }

    public MediaSession a(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str);
    }

    public final r b() {
        r rVar;
        synchronized (this.f5850d) {
            rVar = this.f5856l;
        }
        return rVar;
    }

    public b0 c() {
        b0 b0Var;
        synchronized (this.f5850d) {
            b0Var = this.f5857m;
        }
        return b0Var;
    }

    public void d(b0 b0Var) {
        synchronized (this.f5850d) {
            this.f5857m = b0Var;
        }
    }
}
