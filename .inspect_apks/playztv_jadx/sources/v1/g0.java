package v1;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends c {
    public final DatagramPacket A;
    public Uri B;
    public DatagramSocket C;
    public MulticastSocket D;
    public InetAddress E;
    public boolean F;
    public int G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f13137y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final byte[] f13138z;

    public g0() {
        super(true);
        this.f13137y = 8000;
        byte[] bArr = new byte[2000];
        this.f13138z = bArr;
        this.A = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // v1.h
    public final void close() {
        this.B = null;
        MulticastSocket multicastSocket = this.D;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.E;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.D = null;
        }
        DatagramSocket datagramSocket = this.C;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.C = null;
        }
        this.E = null;
        this.G = 0;
        if (this.F) {
            this.F = false;
            c();
        }
    }

    @Override // v1.h
    public final long h(m mVar) throws f0 {
        Uri uri = mVar.f13157a;
        this.B = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.B.getPort();
        d();
        try {
            this.E = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.E, port);
            if (this.E.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.D = multicastSocket;
                multicastSocket.joinGroup(this.E);
                this.C = this.D;
            } else {
                this.C = new DatagramSocket(inetSocketAddress);
            }
            this.C.setSoTimeout(this.f13137y);
            this.F = true;
            e(mVar);
            return -1L;
        } catch (IOException e10) {
            throw new f0(e10, 2001);
        } catch (SecurityException e11) {
            throw new f0(e11, 2006);
        }
    }

    @Override // v1.h
    public final Uri o() {
        return this.B;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws f0 {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.G;
        DatagramPacket datagramPacket = this.A;
        if (i11 == 0) {
            try {
                DatagramSocket datagramSocket = this.C;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.G = length;
                b(length);
            } catch (SocketTimeoutException e10) {
                throw new f0(e10, 2002);
            } catch (IOException e11) {
                throw new f0(e11, 2001);
            }
        }
        int length2 = datagramPacket.getLength();
        int i12 = this.G;
        int iMin = Math.min(i12, i10);
        System.arraycopy(this.f13138z, length2 - i12, bArr, i, iMin);
        this.G -= iMin;
        return iMin;
    }
}
