package androidx.lifecycle;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e0 {
    public static /* synthetic */ MediaSession c(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }
}
