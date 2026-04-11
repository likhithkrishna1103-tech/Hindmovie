package k8;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f7264w;

    public /* synthetic */ i(k kVar, int i) {
        this.f7263v = i;
        this.f7264w = kVar;
    }

    private final void a() {
        k kVar = this.f7264w;
        synchronized (kVar) {
            if (kVar.f7268v == 1) {
                kVar.a("Timed out while binding");
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7263v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                a();
                return;
            default:
                this.f7264w.a("Service disconnected");
                return;
        }
        while (true) {
            k kVar = this.f7264w;
            synchronized (kVar) {
                try {
                    if (kVar.f7268v != 2) {
                        return;
                    }
                    if (kVar.f7271y.isEmpty()) {
                        kVar.c();
                        return;
                    }
                    l lVar = (l) kVar.f7271y.poll();
                    kVar.f7272z.put(lVar.f7273a, lVar);
                    ((ScheduledExecutorService) kVar.A.f7281x).schedule(new j(0, kVar, lVar), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(lVar)));
                    }
                    m mVar = kVar.A;
                    Messenger messenger = kVar.f7269w;
                    int i = lVar.f7275c;
                    Context context = (Context) mVar.f7280w;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i;
                    messageObtain.arg1 = lVar.f7273a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", lVar.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", lVar.f7276d);
                    messageObtain.setData(bundle);
                    try {
                        i2.k kVar2 = kVar.f7270x;
                        Messenger messenger2 = (Messenger) kVar2.f6085v;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            g gVar = (g) kVar2.f6086w;
                            if (gVar == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = gVar.f7259v;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e9) {
                        kVar.a(e9.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}
