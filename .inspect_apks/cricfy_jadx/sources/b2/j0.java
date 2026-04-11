package b2;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends c {
    public final byte[] A;
    public final DatagramPacket B;
    public Uri C;
    public DatagramSocket D;
    public MulticastSocket E;
    public InetAddress F;
    public boolean G;
    public int H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f1695z;

    public j0() {
        super(true);
        this.f1695z = 8000;
        byte[] bArr = new byte[2000];
        this.A = bArr;
        this.B = new DatagramPacket(bArr, 0, 2000);
    }

    @Override // b2.h
    public final long B(o oVar) throws i0 {
        Uri uri = oVar.f1714a;
        this.C = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.C.getPort();
        e();
        try {
            this.F = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.F, port);
            if (this.F.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.E = multicastSocket;
                multicastSocket.joinGroup(this.F);
                this.D = this.E;
            } else {
                this.D = new DatagramSocket(inetSocketAddress);
            }
            this.D.setSoTimeout(this.f1695z);
            this.G = true;
            f(oVar);
            return -1L;
        } catch (IOException e9) {
            throw new i0(e9, 2001);
        } catch (SecurityException e10) {
            throw new i0(e10, 2006);
        }
    }

    @Override // b2.h
    public final void close() {
        this.C = null;
        MulticastSocket multicastSocket = this.E;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.F;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.E = null;
        }
        DatagramSocket datagramSocket = this.D;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.D = null;
        }
        this.F = null;
        this.H = 0;
        if (this.G) {
            this.G = false;
            c();
        }
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws i0 {
        if (i10 == 0) {
            return 0;
        }
        int i11 = this.H;
        DatagramPacket datagramPacket = this.B;
        if (i11 == 0) {
            try {
                DatagramSocket datagramSocket = this.D;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.H = length;
                b(length);
            } catch (SocketTimeoutException e9) {
                throw new i0(e9, 2002);
            } catch (IOException e10) {
                throw new i0(e10, 2001);
            }
        }
        int length2 = datagramPacket.getLength();
        int i12 = this.H;
        int iMin = Math.min(i12, i10);
        System.arraycopy(this.A, length2 - i12, bArr, i, iMin);
        this.H -= iMin;
        return iMin;
    }

    @Override // b2.h
    public final Uri t() {
        return this.C;
    }
}
