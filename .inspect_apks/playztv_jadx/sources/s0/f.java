package s0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final InputContentInfo f11642u;

    public f(Object obj) {
        this.f11642u = (InputContentInfo) obj;
    }

    @Override // s0.g
    public final ClipDescription a() {
        return this.f11642u.getDescription();
    }

    @Override // s0.g
    public final Object c() {
        return this.f11642u;
    }

    @Override // s0.g
    public final Uri d() {
        return this.f11642u.getContentUri();
    }

    @Override // s0.g
    public final void e() {
        this.f11642u.requestPermission();
    }

    @Override // s0.g
    public final Uri h() {
        return this.f11642u.getLinkUri();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f11642u = new InputContentInfo(uri, clipDescription, uri2);
    }
}
