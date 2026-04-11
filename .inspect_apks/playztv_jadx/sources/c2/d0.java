package c2;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends AudioTrack$StreamEventCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a7.b f2257a;

    public d0(a7.b bVar) {
        this.f2257a = bVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        e0 e0Var;
        n nVar;
        if (audioTrack.equals(((e0) this.f2257a.f620x).f2295w) && (nVar = (e0Var = (e0) this.f2257a.f620x).f2291s) != null && e0Var.W) {
            nVar.E();
        }
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        if (audioTrack.equals(((e0) this.f2257a.f620x).f2295w)) {
            ((e0) this.f2257a.f620x).V = true;
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        e0 e0Var;
        n nVar;
        if (audioTrack.equals(((e0) this.f2257a.f620x).f2295w) && (nVar = (e0Var = (e0) this.f2257a.f620x).f2291s) != null && e0Var.W) {
            nVar.E();
        }
    }
}
