package p7;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10269u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f10270v;

    public /* synthetic */ j(k kVar, int i) {
        this.f10269u = i;
        this.f10270v = kVar;
    }

    private final void a() {
        k kVar = this.f10270v;
        synchronized (kVar) {
            if (kVar.f10271u == 1) {
                kVar.a("Timed out while binding");
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10269u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                a();
                return;
            default:
                this.f10270v.a("Service disconnected");
                return;
        }
        while (true) {
            k kVar = this.f10270v;
            synchronized (kVar) {
                try {
                    if (kVar.f10271u != 2) {
                        return;
                    }
                    if (kVar.f10274x.isEmpty()) {
                        kVar.c();
                        return;
                    }
                    l lVar = (l) kVar.f10274x.poll();
                    kVar.f10275y.put(lVar.f10277a, lVar);
                    ((ScheduledExecutorService) kVar.f10276z.f10285w).schedule(new i(kVar, lVar, 1), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(lVar)));
                    }
                    m mVar = kVar.f10276z;
                    Messenger messenger = kVar.f10272v;
                    int i = lVar.f10279c;
                    Context context = (Context) mVar.f10284v;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i;
                    messageObtain.arg1 = lVar.f10277a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", lVar.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", lVar.f10280d);
                    messageObtain.setData(bundle);
                    try {
                        p2.c cVar = kVar.f10273w;
                        Messenger messenger2 = (Messenger) cVar.f10130v;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            g gVar = (g) cVar.f10131w;
                            if (gVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = gVar.f10262u;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e10) {
                        kVar.a(e10.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}
