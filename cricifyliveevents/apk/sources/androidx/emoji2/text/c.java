package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
