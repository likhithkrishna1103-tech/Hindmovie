package t0;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static f b(View view, f fVar) {
        ContentInfo contentInfoS = fVar.f11742a.s();
        Objects.requireNonNull(contentInfoS);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoS);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoS ? fVar : new f(new kf.i(contentInfoPerformReceiveContent));
    }
}
