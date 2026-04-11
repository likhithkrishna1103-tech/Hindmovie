package g2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f4616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y1.x f4617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.l f4618c;

    public a(com.bumptech.glide.l lVar, y1.x xVar, d0 d0Var) {
        this.f4618c = lVar;
        this.f4617b = xVar;
        this.f4616a = d0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f4617b.c(new androidx.emoji2.text.w(8, this));
        }
    }
}
