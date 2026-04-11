package v0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final InputContentInfo f12550v;

    public f(Object obj) {
        this.f12550v = (InputContentInfo) obj;
    }

    @Override // v0.g
    public final ClipDescription a() {
        return this.f12550v.getDescription();
    }

    @Override // v0.g
    public final Object c() {
        return this.f12550v;
    }

    @Override // v0.g
    public final Uri f() {
        return this.f12550v.getContentUri();
    }

    @Override // v0.g
    public final void g() {
        this.f12550v.requestPermission();
    }

    @Override // v0.g
    public final Uri h() {
        return this.f12550v.getLinkUri();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f12550v = new InputContentInfo(uri, clipDescription, uri2);
    }
}
