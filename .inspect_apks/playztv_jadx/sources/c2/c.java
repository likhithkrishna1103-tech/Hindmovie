package c2;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2251a;

    public c(f fVar) {
        this.f2251a = fVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        f fVar = this.f2251a;
        fVar.a(b.c((Context) fVar.f2300b, (p1.d) fVar.f2306j, (wb.c) fVar.i));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        f fVar = this.f2251a;
        if (s1.b0.l(audioDeviceInfoArr, (wb.c) fVar.i)) {
            fVar.i = null;
        }
        fVar.a(b.c((Context) fVar.f2300b, (p1.d) fVar.f2306j, (wb.c) fVar.i));
    }
}
