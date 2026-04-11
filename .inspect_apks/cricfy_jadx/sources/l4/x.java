package l4;

import android.media.session.MediaSessionManager;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class x extends w {
    @Override // l4.w
    public final e0 c() {
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.f7765a.getCurrentControllerInfo();
        e0 e0Var = new e0();
        String packageName = currentControllerInfo.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(packageName)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        e0Var.f7710a = new f0(currentControllerInfo.getPid(), currentControllerInfo.getUid(), currentControllerInfo.getPackageName());
        return e0Var;
    }

    @Override // l4.w
    public final void d(e0 e0Var) {
    }
}
