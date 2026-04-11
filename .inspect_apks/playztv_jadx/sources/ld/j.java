package ld;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import pc.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public IOException f8150u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8151v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ m f8152w;

    public j(m mVar) {
        this.f8152w = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8152w.f8154a.bind(new InetSocketAddress(9867));
            this.f8151v = true;
            do {
                try {
                    Socket socketAccept = this.f8152w.f8154a.accept();
                    socketAccept.setSoTimeout(5000);
                    InputStream inputStream = socketAccept.getInputStream();
                    m mVar = this.f8152w;
                    mVar.f8156c.F(new ab.c(mVar, inputStream, socketAccept, 10));
                } catch (IOException e10) {
                    k.f8153d.log(Level.FINE, "Communication with the client broken", (Throwable) e10);
                }
            } while (!this.f8152w.f8154a.isClosed());
        } catch (IOException e11) {
            this.f8150u = e11;
        }
    }
}
