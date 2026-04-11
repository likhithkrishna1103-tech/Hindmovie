package pd;

import f9.v1;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import z5.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IOException f10208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10209w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ l f10210x;

    public h(l lVar) {
        this.f10210x = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10210x.f10212a.bind(new InetSocketAddress(9867));
            this.f10209w = true;
            do {
                try {
                    Socket socketAccept = this.f10210x.f10212a.accept();
                    socketAccept.setSoTimeout(5000);
                    InputStream inputStream = socketAccept.getInputStream();
                    l lVar = this.f10210x;
                    lVar.f10214c.F(new v1(lVar, inputStream, socketAccept, 11));
                } catch (IOException e9) {
                    i.f10211d.log(Level.FINE, "Communication with the client broken", (Throwable) e9);
                }
            } while (!this.f10210x.f10212a.isClosed());
        } catch (IOException e10) {
            this.f10208v = e10;
        }
    }
}
