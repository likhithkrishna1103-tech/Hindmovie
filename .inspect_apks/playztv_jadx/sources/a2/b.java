package a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.y f159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f160c;

    public b(c cVar, s1.y yVar, l0 l0Var) {
        this.f160c = cVar;
        this.f159b = yVar;
        this.f158a = l0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f159b.c(new a(1, this));
        }
    }
}
