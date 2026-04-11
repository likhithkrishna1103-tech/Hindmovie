package i2;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AudioDeviceCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f5985a;

    public d(f fVar) {
        this.f5985a = fVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        f fVar = this.f5985a;
        fVar.d(c.c((Context) fVar.f5993b, (v1.c) fVar.f5999j, (p6.d) fVar.i));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        f fVar = this.f5985a;
        if (y1.a0.l(audioDeviceInfoArr, (p6.d) fVar.i)) {
            fVar.i = null;
        }
        fVar.d(c.c((Context) fVar.f5993b, (v1.c) fVar.f5999j, (p6.d) fVar.i));
    }
}
