```mermaid
stateDiagram-v2
    [*] --> JOINING
    JOINING --> BIDDING : receive price
    JOINING --> LOST    : auction closed
    BIDDING --> WINNING : price ≤ bid
    BIDDING --> BIDDING : price > bid / new bid
    BIDDING --> LOST    : auction closed
    WINNING --> BIDDING : price > bid / new bid
    WINNING --> WON     : auction closed
```