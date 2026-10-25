public class NetworkPacket {
    private String packetId;
    private int payloadByte;

    public NetworkPacket(String packetId, int payloadByte) {
        this.packetId = packetId;
        this.payloadByte = payloadByte;
    }

    public String getPacketId() {
        return packetId;
    }

    public int getPayloadByte() {
        return payloadByte;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NetworkPacket packet = (NetworkPacket) obj;
        return payloadByte == packet.payloadByte;
    }
}